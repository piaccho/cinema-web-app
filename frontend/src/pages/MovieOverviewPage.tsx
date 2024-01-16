import React, { useEffect, useRef, useState } from 'react';
import { Box, Card, Container, Grid, Typography } from '@mui/material';
import MovieOverviewCard from '../components/MovieOverviewCard';
import { useLocation } from 'react-router-dom';
import { ShowingList } from '../types';
import ApiService from '../ApiService';
import MovieOverviewShowing from '../components/MovieOverviewShowing';

const MovieOverviewPage: React.FC = () => {
    const location = useLocation();
    const movie = location.state.movie;
    const [showingLists, setShowingLists] = useState<ShowingList[]>([]);
    const apiService = new ApiService();

    const showingRef = useRef<HTMLDivElement | null>(null);

    const handleScrollToShowing = () => {
        if (showingRef.current) {
            showingRef.current.scrollIntoView({ behavior: 'smooth' });
        }
    };
    
    useEffect(() => {
        const fetchShowings = async () => {
            setShowingLists(await apiService.getShowingListsByMovieId(movie.id));
        };
        fetchShowings();
    }, []);

    return (
        <Container maxWidth="xl">
            <Grid container spacing={2} display='flex' direction='column' alignItems='center' mb={5}>
                <MovieOverviewCard movie={movie} onButtonClick={handleScrollToShowing} />
                <Box ref={showingRef} sx={{ display: 'flex', flexDirection: 'column', width: '1000px', marginTop: '100px', marginBottom: '20px' }}>
                    <Typography variant="h4" mb={2} sx={{ color: 'primary.main', fontWeight: 'Bold' }}>
                        Repertoires:
                    </Typography>
                    <Grid container spacing={4} >
                        {showingLists.map((showingList) => (
                            <MovieOverviewShowing showingList={showingList} key={showingList.id} />
                        ))}
                    </Grid>
                </Box>
            </Grid>
        </Container>
    );
};

export default MovieOverviewPage;
