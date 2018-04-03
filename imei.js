/**
 * @providesModule react-native-imei
 */

 import { NativeModules, Platform } from 'react-native';

 if (Platform.OS === "android") {
     module.exports = {
       getImei: async function () {
         return await NativeModules.IMEI.getImei();
       }
     };
 } else {
     module.exports = {
         getImei: function () {
             throw new Error("Not implemented");
         }
     }
 }
