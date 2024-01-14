import React, { useEffect, useState } from 'react';
import { AppBar, Toolbar, IconButton, Typography, Button, TextField, Box } from '@mui/material';
// import Carousel from './components/Carousel'
import ApiService from './ApiService';
import { Genre, Movie } from './types';
// import { Routes, Route, Outlet, Link } from "react-router-dom";

const CarouselItem: React.FC<{ movie: Movie }> = ({ movie }) => (
  <div>
    <img src={movie.image} alt={movie.title} />
    <p className="legend">{movie.title}</p>
    <p>{movie.releaseDate}</p>
  </div>
);

const App = () => {
  const [popularMovies, setPopularMovies] = useState<Movie[]>([]);
  const [upcomingMovies, setUpcomingMovies] = useState<Movie[]>([]);
  const apiService = new ApiService();

  useEffect(() => {
    const fetchPopularMovies = async () => {
      const posts = await apiService.getPopularMovies();
      setPopularMovies(posts);
    };

    const fetchUpcomingMovies = async () => {
      const posts = await apiService.getUpcomingMovies();
      setUpcomingMovies(posts);
    };

    fetchPopularMovies();
    fetchUpcomingMovies();
  }, []);
  const movies: Movie[] = [
    {
      "id": 872585,
      "adult": false,
      "genres": [
        "Drama",
        "History"
      ],
      "title": "Oppenheimer",
      "originalTitle": "Oppenheimer",
      "releaseDate": "2023-07-19",
      "image": "https://image.tmdb.org/t/p/w500/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
      "overview": "The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.",
      "voteAverage": 8.116,
      "voteCount": 6078,
      "popularity": 703.156,
      "originalLanguage": "en"
    },
    {
      "id": 906126,
      "adult": false,
      "genres": [
        "Drama",
        "History"
      ],
      "title": "Society of the Snow",
      "originalTitle": "La sociedad de la nieve",
      "releaseDate": "2023-12-13",
      "image": "https://image.tmdb.org/t/p/w500/2e853FDVSIso600RqAMunPxiZjq.jpg",
      "overview": "On October 13, 1972, Uruguayan Air Force Flight 571, chartered to take a rugby team to Chile, crashes into a glacier in the heart of the Andes.",
      "voteAverage": 8.072,
      "voteCount": 708,
      "popularity": 1499.994,
      "originalLanguage": "es"
    },
    {
      "id": 507089,
      "adult": false,
      "genres": [
        "Horror",
        "Mystery"
      ],
      "title": "Five Nights at Freddy's",
      "originalTitle": "Five Nights at Freddy's",
      "releaseDate": "2023-10-25",
      "image": "https://image.tmdb.org/t/p/w500/7BpNtNfxuocYEVREzVMO75hso1l.jpg",
      "overview": "Recently fired and desperate for work, a troubled young man named Mike agrees to take a position as a night security guard at an abandoned theme restaurant: Freddy Fazbear's Pizzeria. But he soon discovers that nothing at Freddy's is what it seems.",
      "voteAverage": 7.746,
      "voteCount": 3146,
      "popularity": 849.472,
      "originalLanguage": "en"
    },
    {
      "id": 866398,
      "adult": false,
      "genres": [
        "Action",
        "Thriller"
      ],
      "title": "The Beekeeper",
      "originalTitle": "The Beekeeper",
      "releaseDate": "2024-01-10",
      "image": "https://image.tmdb.org/t/p/w500/mlHDJE9sE3quNRr6bVULfOrIU7S.jpg",
      "overview": "One man’s campaign for vengeance takes on national stakes after he is revealed to be a former operative of a powerful and clandestine organization known as Beekeepers.",
      "voteAverage": 7.616,
      "voteCount": 43,
      "popularity": 786.863,
      "originalLanguage": "en"
    },
    {
      "id": 1075794,
      "adult": false,
      "genres": [
        "Animation",
        "Comedy",
        "Family"
      ],
      "title": "Leo",
      "originalTitle": "Leo",
      "releaseDate": "2023-11-17",
      "image": "https://image.tmdb.org/t/p/w500/pD6sL4vntUOXHmuvJPPZAgvyfd9.jpg",
      "overview": "Jaded 74-year-old lizard Leo has been stuck in the same Florida classroom for decades with his terrarium-mate turtle. When he learns he only has one year left to live, he plans to escape to experience life on the outside but instead gets caught up in the problems of his anxious students — including an impossibly mean substitute teacher.",
      "voteAverage": 7.526,
      "voteCount": 807,
      "popularity": 637.2,
      "originalLanguage": "en"
    },
    {
      "id": 1029575,
      "adult": false,
      "genres": [
        "Action",
        "Comedy"
      ],
      "title": "The Family Plan",
      "originalTitle": "The Family Plan",
      "releaseDate": "2023-12-14",
      "image": "https://image.tmdb.org/t/p/w500/a6syn9qcU4a54Lmi3JoIr1XvhFU.jpg",
      "overview": "Dan Morgan is many things: a devoted husband, a loving father, a celebrated car salesman. He's also a former assassin. And when his past catches up to his present, he's forced to take his unsuspecting family on a road trip unlike any other.",
      "voteAverage": 7.375,
      "voteCount": 691,
      "popularity": 624.114,
      "originalLanguage": "en"
    },
    {
      "id": 695721,
      "adult": false,
      "genres": [
        "Action",
        "Drama",
        "Science Fiction"
      ],
      "title": "The Hunger Games: The Ballad of Songbirds & Snakes",
      "originalTitle": "The Hunger Games: The Ballad of Songbirds & Snakes",
      "releaseDate": "2023-11-15",
      "image": "https://image.tmdb.org/t/p/w500/mBaXZ95R2OxueZhvQbcEWy2DqyO.jpg",
      "overview": "64 years before he becomes the tyrannical president of Panem, Coriolanus Snow sees a chance for a change in fortunes when he mentors Lucy Gray Baird, the female tribute from District 12.",
      "voteAverage": 7.23,
      "voteCount": 1458,
      "popularity": 677.391,
      "originalLanguage": "en"
    },
    {
      "id": 901362,
      "adult": false,
      "genres": [
        "Animation",
        "Comedy",
        "Family",
        "Fantasy",
        "Music"
      ],
      "title": "Trolls Band Together",
      "originalTitle": "Trolls Band Together",
      "releaseDate": "2023-10-12",
      "image": "https://image.tmdb.org/t/p/w500/bkpPTZUdq31UGDovmszsg2CchiI.jpg",
      "overview": "When Branch's brother, Floyd, is kidnapped for his musical talents by a pair of nefarious pop-star villains, Branch and Poppy embark on a harrowing and emotional journey to reunite the other brothers and rescue Floyd from a fate even worse than pop-culture obscurity.",
      "voteAverage": 7.225,
      "voteCount": 516,
      "popularity": 657.985,
      "originalLanguage": "en"
    },
    {
      "id": 930564,
      "adult": false,
      "genres": [
        "Comedy",
        "Drama",
        "Thriller"
      ],
      "title": "Saltburn",
      "originalTitle": "Saltburn",
      "releaseDate": "2023-11-16",
      "image": "https://image.tmdb.org/t/p/w500/qjhahNLSZ705B5JP92YMEYPocPz.jpg",
      "overview": "Struggling to find his place at Oxford University, student Oliver Quick finds himself drawn into the world of the charming and aristocratic Felix Catton, who invites him to Saltburn, his eccentric family's sprawling estate, for a summer never to be forgotten.",
      "voteAverage": 7.153,
      "voteCount": 1070,
      "popularity": 522.643,
      "originalLanguage": "en"
    },
    {
      "id": 787699,
      "adult": false,
      "genres": [
        "Comedy",
        "Family",
        "Fantasy"
      ],
      "title": "Wonka",
      "originalTitle": "Wonka",
      "releaseDate": "2023-12-06",
      "image": "https://image.tmdb.org/t/p/w500/qhb1qOilapbapxWQn9jtRCMwXJF.jpg",
      "overview": "Willy Wonka – chock-full of ideas and determined to change the world one delectable bite at a time – is proof that the best things in life begin with a dream, and if you’re lucky enough to meet Willy Wonka, anything is possible.",
      "voteAverage": 7.114,
      "voteCount": 961,
      "popularity": 701.384,
      "originalLanguage": "en"
    },
    {
      "id": 1020006,
      "adult": false,
      "genres": [
        "Drama",
        "Romance"
      ],
      "title": "Priscilla",
      "originalTitle": "Priscilla",
      "releaseDate": "2023-10-27",
      "image": "https://image.tmdb.org/t/p/w500/uDCeELWWpsNq7ErM61Yuq70WAE9.jpg",
      "overview": "When teenage Priscilla Beaulieu meets Elvis Presley at a party, the man who is already a meteoric rock-and-roll superstar becomes someone entirely unexpected in private moments: a thrilling crush, an ally in loneliness, a vulnerable best friend.",
      "voteAverage": 6.9,
      "voteCount": 208,
      "popularity": 474.53,
      "originalLanguage": "en"
    },
    {
      "id": 772,
      "adult": false,
      "genres": [
        "Adventure",
        "Comedy",
        "Family"
      ],
      "title": "Home Alone 2: Lost in New York",
      "originalTitle": "Home Alone 2: Lost in New York",
      "releaseDate": "1992-11-19",
      "image": "https://image.tmdb.org/t/p/w500/uuitWHpJwxD1wruFl2nZHIb4UGN.jpg",
      "overview": "Instead of flying to Florida with his folks, Kevin ends up alone in New York, where he gets a hotel room with his dad's credit card—despite problems from a clerk and meddling bellboy. But when Kevin runs into his old nemeses, the Wet Bandits, he's determined to foil their plans to rob a toy store on Christmas Eve.",
      "voteAverage": 6.727,
      "voteCount": 9016,
      "popularity": 572.743,
      "originalLanguage": "en"
    },
    {
      "id": 1071215,
      "adult": false,
      "genres": [
        "Horror",
        "Mystery",
        "Thriller"
      ],
      "title": "Thanksgiving",
      "originalTitle": "Thanksgiving",
      "releaseDate": "2023-11-16",
      "image": "https://image.tmdb.org/t/p/w500/f5f3TEVst1nHHyqgn7Z3tlwnBIH.jpg",
      "overview": "After a Black Friday riot ends in tragedy, a mysterious Thanksgiving-inspired killer terrorizes Plymouth, Massachusetts - the birthplace of the holiday. Picking off residents one by one, what begins as random revenge killings are soon revealed to be part of a larger, sinister holiday plan.",
      "voteAverage": 6.712,
      "voteCount": 500,
      "popularity": 1085.668,
      "originalLanguage": "en"
    },
    {
      "id": 572802,
      "adult": false,
      "genres": [
        "Action",
        "Adventure",
        "Fantasy"
      ],
      "title": "Aquaman and the Lost Kingdom",
      "originalTitle": "Aquaman and the Lost Kingdom",
      "releaseDate": "2023-12-20",
      "image": "https://image.tmdb.org/t/p/w500/8xV47NDrjdZDpkVcCFqkdHa3T0C.jpg",
      "overview": "Black Manta, still driven by the need to avenge his father's death and wielding the power of the mythic Black Trident, will stop at nothing to take Aquaman down once and for all. To defeat him, Aquaman must turn to his imprisoned brother Orm, the former King of Atlantis, to forge an unlikely alliance in order to save the world from irreversible destruction.",
      "voteAverage": 6.479,
      "voteCount": 475,
      "popularity": 1213.101,
      "originalLanguage": "en"
    },
    {
      "id": 753342,
      "adult": false,
      "genres": [
        "Drama",
        "History",
        "War"
      ],
      "title": "Napoleon",
      "originalTitle": "Napoleon",
      "releaseDate": "2023-11-22",
      "image": "https://image.tmdb.org/t/p/w500/jE5o7y9K6pZtWNNMEw3IdpHuncR.jpg",
      "overview": "An epic that details the checkered rise and fall of French Emperor Napoleon Bonaparte and his relentless journey to power through the prism of his addictive, volatile relationship with his wife, Josephine.",
      "voteAverage": 6.457,
      "voteCount": 1069,
      "popularity": 2141.546,
      "originalLanguage": "en"
    },
    {
      "id": 848326,
      "adult": false,
      "genres": [
        "Action",
        "Drama",
        "Science Fiction"
      ],
      "title": "Rebel Moon - Part One: A Child of Fire",
      "originalTitle": "Rebel Moon - Part One: A Child of Fire",
      "releaseDate": "2023-12-15",
      "image": "https://image.tmdb.org/t/p/w500/ui4DrH1cKk2vkHshcUcGt2lKxCm.jpg",
      "overview": "When a peaceful colony on the edge of the galaxy finds itself threatened by the armies of the tyrannical Regent Balisarius, they dispatch Kora, a young woman with a mysterious past, to seek out warriors from neighboring planets to help them take a stand.",
      "voteAverage": 6.434,
      "voteCount": 1204,
      "popularity": 619.062,
      "originalLanguage": "en"
    },
    {
      "id": 1035982,
      "adult": false,
      "genres": [
        "Horror",
        "Mystery"
      ],
      "title": "Hell House LLC Origins: The Carmichael Manor",
      "originalTitle": "Hell House LLC Origins: The Carmichael Manor",
      "releaseDate": "2023-10-24",
      "image": "https://image.tmdb.org/t/p/w500/irxr1vZdpQl7Vnn8vdysnD69uba.jpg",
      "overview": "A group of cold case investigators stay at the Carmichael Manor, site of the grisly and unsolved murders of the Carmichael family back in the eighties. After four nights, the group was never heard from again. What is discovered on their footage is even more disturbing than anything found on the Hell House tapes.",
      "voteAverage": 6.304,
      "voteCount": 56,
      "popularity": 434.125,
      "originalLanguage": "en"
    },
    {
      "id": 1131755,
      "adult": false,
      "genres": [
        "Horror"
      ],
      "title": "A Creature Was Stirring",
      "originalTitle": "A Creature Was Stirring",
      "releaseDate": "2023-12-08",
      "image": "https://image.tmdb.org/t/p/w500/ikQG3byEFyfwcnF0zmyNtXTmr5v.jpg",
      "overview": "A nurse taking care of her daughter's mysterious affliction struggles to hide her secrets when uninvited strangers take shelter in her house during a lethal blizzard.",
      "voteAverage": 6.031,
      "voteCount": 32,
      "popularity": 626.592,
      "originalLanguage": "en"
    },
    {
      "id": 843380,
      "adult": false,
      "genres": [
        "Action",
        "Thriller",
        "Western"
      ],
      "title": "Dead for a Dollar",
      "originalTitle": "Dead for a Dollar",
      "releaseDate": "2022-09-30",
      "image": "https://image.tmdb.org/t/p/w500/1AnXfjxFqMsQmUPSvt9YxUJhfFw.jpg",
      "overview": "In 1897, veteran bounty hunter Max Borlund is deep into Mexico where he encounters professional gambler and outlaw Joe Cribbens — a sworn enemy he sent to prison years before. Max is on a mission to find and return Rachel Kidd, the wife of a wealthy businessman, who as the story is told to Max, has been abducted by Buffalo Soldier Elijah Jones. Max is ultimately faced with a showdown to save honor.",
      "voteAverage": 5.68,
      "voteCount": 183,
      "popularity": 550.679,
      "originalLanguage": "en"
    },
    {
      "id": 899445,
      "adult": false,
      "genres": [
        "Action",
        "Horror",
        "Mystery",
        "Thriller"
      ],
      "title": "Deep Fear",
      "originalTitle": "Deep Fear",
      "releaseDate": "2023-10-18",
      "image": "https://image.tmdb.org/t/p/w500/ruujFw7J0Nd3BSjbN3QODym82Qs.jpg",
      "overview": "A solo trip aboard a yacht takes a terrifying turn when a woman encounters three drug traffickers clinging to the shattered remains of a boat. They soon force her to dive into shark-infested waters to retrieve kilos of cocaine from the sunken wreck.",
      "voteAverage": 4.809,
      "voteCount": 34,
      "popularity": 884.386,
      "originalLanguage": "en"
    }
  ];

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
      {/* <SignIn /> */}
      {movies.map((movie) => (
        <CarouselItem movie={movie} />
      ))}
      {/* <Carousel elements={popularMovies.map((movie) => (
        <CarouselItem movie={movie} />
      ))}/>
      <Carousel elements={upcomingMovies.map((movie) => (
        <CarouselItem movie={movie} />
      ))}/> */}
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
