import React, { useEffect, useState } from 'react';
import { AppBar, Toolbar, IconButton, Typography, Button, TextField, Box } from '@mui/material';
import Carousel from './components/Carousel'

const CarouselItem = ({ title, date }: { title: string, date: string }) => (
  <div>
    <img src="movie_thumbnail.jpg" alt={title} />
    <p className="legend">{title}</p>
    <p>{date}</p>
  </div>
);

const App = () => {
  const [movies, setMovies] = useState([]);

  useEffect(() => {
    fetchMovies();
  }, []);

  const fetchMovies = async () => {
    try {
      const response = await fetch('https://api.example.com/movies');
      const data = await response.json();
      setMovies(data);
    } catch (error) {
      console.error('Error fetching movies:', error);
    }
  };

  return (
    <div>
      <AppBar position="static">
        <Toolbar>
          <IconButton edge="start" color="inherit" aria-label="logo">
            <img src="logo.jpg" alt="Logo" />
          </IconButton>
          <Button color="inherit">Logowanie</Button>
          <Button color="inherit">Rejestracja</Button>
          <TextField id="search" label="Wyszukaj" variant="filled" />
        </Toolbar>
      </AppBar>
      <nav>
        <Button>Repertuar</Button>
        <Button>Oferty</Button>
      </nav>
      <Carousel>
        {movies.map((movie) => (
          <CarouselItem key={movie.id} title={movie.title} date={movie.date} />
        ))}
      </Carousel>
      <footer>
        <Box display="flex" justifyContent="space-between">
          <div>O nas</div>
          <div>Informacje</div>
          <div>Obserwuj nas</div>
        </Box>
        <Typography variant="body2" color="textSecondary" align="center">
          {'Copyright © '}
          {new Date().getFullYear()}
          {'.'}
        </Typography>
      </footer>
    </div>
  );
}

export default App;
