# react-native-multi-manufacturer-power-manager

## Getting started

`$ npm install react-native-multi-manufacturer-power-manager --save`

### Mostly automatic installation

`$ react-native link react-native-multi-manufacturer-power-manager`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainApplication.java`
  - Add `import com.rnmmpowermanager.MultiManufacturerPowerManagerPackage;` to the imports at the top of the file
  - Add `new MultiManufacturerPowerManagerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-multi-manufacturer-power-manager'
  	project(':react-native-multi-manufacturer-power-manager').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-multi-manufacturer-power-manager/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-multi-manufacturer-power-manager')
  	```


## Usage
```javascript
import MultiManufacturerPowerManager from 'react-native-multi-manufacturer-power-manager';

// TODO: What to do with the module?
MultiManufacturerPowerManager;
```
