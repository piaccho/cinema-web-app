export interface Movie {
    id: number;
    adult: boolean;
    genres: string[];
    title: string;
    originalTitle: string;
    releaseDate: string;
    image: string;
    overview: string;
    voteAverage: number;
    voteCount: number;
    popularity: number;
    originalLanguage: string;
}

export interface Genre {
    id: number;
    name: string;
}
