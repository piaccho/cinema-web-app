import { createTheme } from '@mui/material/styles';
import { orange, red, grey, green } from '@mui/material/colors';

// A custom theme for this app
const theme = createTheme({
  // palette https://www.colorhunt.co/palette/37306b66347f9e4784d27685
  // #37306B
  // #66347F
  // #9E4784
  // #D27685

  palette: {
    primary: {
      main: "#37306B", 
      light: "#FFCDB2",
      dark: "#D6875",
    },
    secondary: {
      main: '#19857b',
    },
    error: {
      main: red.A400,
    },
    warning: {
      main: orange.A400,
    },
    info: {
      main: grey.A400,
    },
    success: {
      main: green.A400,
    },
  },
  typography: {
    fontFamily: [
      'Noto Sans',
      'Lora', 
      'Arial',
      'sans-serif'
    ].join(','),
  },
});

export default theme;