import React, { useState } from 'react';
import { Button, Box } from '@mui/material';

interface CarouselProps {
    elements: React.ReactNode[];
}

const Carousel: React.FC<CarouselProps> = ({ elements }) => {
    const [currentIndex, setCurrentIndex] = useState(0);

    const handleMoveLeft = () => {
        setCurrentIndex((prevIndex) => prevIndex - 1);
    };

    const handleMoveRight = () => {
        setCurrentIndex((prevIndex) => prevIndex + 1);
    };

    return (
        <Box display="flex" alignItems="center" overflow="hidden">
            <Button disabled={currentIndex === 0} onClick={handleMoveLeft}>
                Left
            </Button>
            <Box display="flex" flexWrap="nowrap" overflow="hidden">
                {elements.map((element, index) => (
                    <Box
                        key={index}
                        width="100%"
                        flexShrink={0}
                        marginLeft={index === 0 ? `-${currentIndex * 100}%` : undefined}
                    >
                        {element}
                    </Box>
                ))}
            </Box>
            <Button
                disabled={currentIndex === elements.length - 1}
                onClick={handleMoveRight}
            >
                Right
            </Button>
        </Box>
    );
};

export default Carousel;
