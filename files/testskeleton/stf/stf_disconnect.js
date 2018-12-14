var Swagger = require('swagger-client');

var serial = process.argv.slice(2)[0]
var STF_URL = process.argv.slice(3)[0]
var STF_TOKEN = process.argv.slice(4)[0]
var SWAGGER_URL = STF_URL + '/api/v1/swagger.json'

var client = new Swagger({
  url: SWAGGER_URL
, usePromise: true
, authorizations: {
    accessTokenAuth: new Swagger.ApiKeyAuthorization('Authorization', 'Bearer ' + STF_TOKEN, 'header')
  }
})

client.then(function(api) {
  return api.user.getUserDevices({
    serial: serial
  , fields: 'serial,present,ready,using,owner'
  }).then(function(res) {
      // check if device can be added or not
      var devices = res.obj.devices

      var hasDevice = false
      devices.forEach(function(device) {
        if(device.serial === serial) {
          hasDevice = true;
        }
      })

      if (!hasDevice) {
        throw new Error('You are not owner')
      }

      return api.user.deleteUserDeviceBySerial({
        serial: serial
      }).then(function(res) {
        if (!res.obj.success) {
          throw new Error('Could not disconnect to device')
        }

        console.log('Device disconnected successfully!')
      })
  })
})
