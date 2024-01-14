import * as React from 'react';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { CardMedia } from '@mui/material';
import { Link } from 'react-router-dom';
import { Movie } from '../types';
import formatDate from '../util/formatDate';

export const CarouselItem: React.FC<{ movie: Movie }> = ({ movie }) => {
    return (
        <Card sx={{ maxWidth: 250, bgcolor: 'white' }}>
            <CardMedia
                component="img"
                image={movie.image}
                alt={movie.title}
            />
            <CardContent>
                <Typography gutterBottom variant="h6" component="div">
                    {movie.title}
                </Typography>
                <Typography variant="body2" color="text.secondary">
                    Premiera: {formatDate(movie.releaseDate)}
                </Typography>
            </CardContent>
        </Card>
        // <Link to={`/movie/${movie.title}`} style={{ textDecoration: 'none' }}>
            
        // </Link>
    );
}

export default CarouselItem;