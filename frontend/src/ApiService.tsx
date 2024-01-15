import axios, { AxiosInstance } from 'axios';
import { API } from './config/config';
import { Genre, Movie, ShowingList } from './types';

// Klasa serwisu API
export default class ApiService {
    private api: AxiosInstance;

    constructor() {
        this.api = axios.create({
            baseURL: API.BASE_URL,
            headers: {
                "Content-type": "application/json",
                'X-RapidAPI-Key': API.KEY,
                'X-RapidAPI-Host': API.HOST,
            }
        });
    }

    async getPopularMovies(): Promise<Movie[]> {
        // const response = await this.api.get<Movie[]>(API.GET_POPULAR_MOVIES);
        // console.log("got popular movies", response.data);
        // return response.data;
        return fetch("src/mocks/popularMovies.json")
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data: Movie[]) => {
                console.log(`Got ${data.length} popular movies`);
                return data;
            });
    }

    async getUpcomingMovies(): Promise<Movie[]> {
        // const response = await this.api.get<Movie[]>(API.GET_UPCOMING_MOVIES);
        // console.log("got upcoming movies", response.data);
        // return response.data;
        return fetch("src/mocks/upcomingMovies.json")
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data: Movie[]) => {
                console.log(`Got ${data.length} upcoming movies`);
                return data;
            });
    }

    async getMoviesGenres(): Promise<Genre[]> {
        // const response = await this.api.get<Movie[]>(API.GET_MOVIES_GENRES);
        // console.log("got movies genres", response.data);
        // return response.data;
        return fetch("/src/mocks/genres.json")
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data: Genre[]) => {
                console.log(`Got ${data.length} genres`);
                return data;
            });
    }

    async getMoviesBySearchQuery(query: String): Promise<Movie[]> {
        // const response = await this.api.get<Movie[]>(`${API.GET_MOVIES_BY_SEARCH_QUERY}${query}`);
        // console.log("got movies", response.data);
        // return response.data;
        return fetch("/src/mocks/searchQueryMovies.json")
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data: Movie[]) => {
                console.log(`Got ${data.length} genres`);
                return data;
            });
    } 

    async getMoviesByGenre(genreName: String): Promise<Movie[]> {
        // const response = await this.api.get<Movie[]>(`${API.GET_MOVIES_BY_GENRE}${genreName}`);
        // console.log("got movies", response.data);
        // return response.data;
        return fetch("/src/mocks/actionMovies.json")
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data: Movie[]) => {
                console.log(`Got ${data.length} genres`);
                return data;
            });
    }

    async getShowingListsByDate(date: String): Promise<ShowingList[]> {
        // const response = await this.api.get<Movie[]>(`${API.GET_REPERTOIRE}${date}`);
        // console.log("got movies", response.data);
        // return response.data;
        return fetch("/src/mocks/showings.json")
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data: ShowingList[]) => {
                console.log(`Got repertoire with ${data.length} showings`);
                return data;
            });
    }

    async getShowingListsById(id: number): Promise<ShowingList[]> {
        // const response = await this.api.get<Movie[]>(`${API.GET_REPERTOIRE}${date}`);
        // console.log("got movies", response.data);
        // return response.data;
        return fetch("/src/mocks/showingsOneMovie.json")
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status}`);
                }
                return response.json();
            })
            .then((data: ShowingList[]) => {
                console.log(`Got ${data.length} repertoires`);
                return data;
            });
    }

    // async createPost(post: Post): Promise<Post> {
    //     const response = await this.api.post<Post>('/posts', post);
    //     return response.data;
    // }

    // async updatePost(id: number, post: Partial<Post>): Promise<Post> {
    //     const response = await this.api.put<Post>(`/posts/${id}`, post);
    //     return response.data;
    // }

    // async deletePost(id: number): Promise<void> {
    //     await this.api.delete(`/posts/${id}`);
    // }
}
