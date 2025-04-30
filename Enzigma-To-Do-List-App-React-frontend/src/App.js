import './App.css';
import { ThemeProvider } from '@emotion/react';
import { darkTheme } from './theme/darktheme';
import Navbar from './components/Navbar/NavBar';

function App() {
  return (
    <ThemeProvider theme = {darkTheme}>
            <Navbar/>
    </ThemeProvider>
  );
}

export default App;
