import axios, { AxiosInstance } from 'axios';
import { API } from './config/config';
import { Movie } from './types';

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
        console.log("start");
        const response = await this.api.get<Movie[]>(API.GET_POPULAR_MOVIES);
        console.log("got popular movies", response.data);
        return response.data;
    }

    async getUpcomingMovies(): Promise<Movie[]> {
        console.log("start");
        const response = await this.api.get<Movie[]>(API.GET_UPCOMING_MOVIES);
        console.log("got upcoming movies", response.data);
        return response.data;
    }

    async getMoviesGenres(): Promise<Movie[]> {
        const response = await this.api.get<Movie[]>(API.GET_MOVIES_GENRES);
        console.log("got movies genres", response.data);
        return response.data;
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
