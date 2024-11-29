package dev.lpa;

public record Seat(char rowMarker, int seatNumber, double price) {

    public Seat(char rowMarker, int seatNumber) {
        this(rowMarker, seatNumber,
                rowMarker > 'C' && (seatNumber <= 2 || seatNumber >= 9) ? 50 : 75);
    }

    @Override
    public String toString() {
        return "%c%03d %.0f".formatted(rowMarker, seatNumber, price);
    }
}
