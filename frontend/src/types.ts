import React from "react";

export interface Movie {
    id: number;
    adult: boolean;
    genres: string[];
    title: string;
    originalTitle: string;
    releaseDate: string;
    image: string;
    overview: string;
    length: number;
    voteAverage: number;
    voteCount: number;
    popularity: number;
    originalLanguage: string;
}

export interface ShowingMovie {
    id: number;
    genres: string[];
    title: string;
    image: string;
    length: number;
}

export interface ShowingListItem {
    time: string;
    hallId: number;
    freeSeats: number;
}

export interface ShowingList {
    id: number;
    movie: ShowingMovie;
    date: string;
    type: 'sub' | 'dub' | 'voiceOver';
    showings: ShowingListItem[];
}

export interface Genre {
    id: number;
    name: string;
}

export interface CarouselProps {
    elements: React.ReactElement[];
}

export interface MoviesListPageProps {
    type: 'searchQuery' | 'genre';
}

export interface MovieOverviewCardProps {
    movie: Movie;
    onButtonClick: () => void;
}