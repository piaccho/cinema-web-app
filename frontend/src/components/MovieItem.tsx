import * as React from 'react';
import { useNavigate } from 'react-router-dom';
import Card from '@mui/material/Card';
import CardContent from '@mui/material/CardContent';
import Typography from '@mui/material/Typography';
import { CardMedia } from '@mui/material';
import { Movie } from '../types';
import formatDate from '../util/formatDate';

const MovieItem: React.FC<{ movie: Movie }> = ({ movie }) => {
    const navigate = useNavigate();

    const handleClick = () => {
        navigate(`/movies/${movie.id}`, { state: { movie } });
    };
    
    return (
        <Card sx={{ maxWidth: 250, bgcolor: 'white', cursor: 'pointer'}} onClick={handleClick}>
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
                    Premiere: {formatDate(movie.releaseDate)}
                </Typography>
            </CardContent>
        </Card>
    );
}

export default MovieItem;