import { GroupedShowings, Showing } from "../types";

export default function groupShowingsByDate(showings: Showing[]): GroupedShowings[] {
    const grouped: { [key: string]: Showing[] } = {};

    for (const showing of showings) {
        const date = showing.datetime.toString().split('T')[0];
        if (!grouped[date]) {
            grouped[date] = [];
        }
        grouped[date].push(showing);
    }

    return Object.keys(grouped).map(date => ({
        date,
        showings: grouped[date],
    }));
}