# react-native-font-list
A basic React Native module that exposes the operating system's installed fonts and available font families. It ships with a single function: `.get()`.

## Installation
### Add Dependency
Yarn:

`yarn add react-native-font-list`

NPM:

`npm install react-native-font-list --save`

### Update Pods (iOS)
`cd ios && pod install`

That's it! You are ready to use FontList.

## Usage
```javascript
// import
import FontList from 'react-native-font-list';

// sample use case
const [availableFontFamilies, setAvailableFontFamilies] = useState([]);
const [installedFonts, setInstalledFonts] = useState([]);

FontList.get((fontFamilies, fonts) => {
  setAvailableFontFamilies(fontFamilies);
  setInstalledFonts(fonts);
});
```

## License
[View License](/LICENSE);
