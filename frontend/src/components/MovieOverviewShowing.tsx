import * as React from 'react';
import Typography from '@mui/material/Typography';
import { Box, Button, Card, CardContent, Grid } from '@mui/material';
import { ShowingList } from '../types';
import formatDate from '../util/formatDate';

const MovieOverviewShowing: React.FC<{ showingList: ShowingList }> = ({ showingList }) => {
    return (
        <Grid item xs={12} md={12}>
            <Card sx={{ display: 'flex' }}>
                <CardContent sx={{ flex: 1 }}>
                    <Typography variant="h6" mb={2} sx={{ fontWeight: 'bold', color: 'primary.main' }}>{formatDate(showingList.date)}</Typography>
                    <Typography variant="body1" mb={3}>
                        {
                            showingList.type === 'dub' ? 'Dubbed'
                                : showingList.type === 'sub' ? 'Subbed'
                                    : 'Voiceover'
                        }
                    </Typography>
                    <Box sx={{ display: 'flex', gap: '10px', flexWrap: 'wrap' }}>
                        {showingList.showings.map((showingTime, index) => (
                            <Button key={index} variant={'contained'} disabled={showingTime.freeSeats <= 0 ? true : false}>{showingTime.time}</Button>
                        ))}
                    </Box>
                </CardContent>
            </Card>
        </Grid>
    );
}

export default MovieOverviewShowing;