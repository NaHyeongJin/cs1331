package hw4;

/**
 * Coordinates
 */
public class Coordinates {
    private final double latitude; // 좌표 집합의 위도
    private final double longitude; // 좌표 집합의 경도

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // 위도 경도 같아야 true
    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Coordinates obj = (Coordinates) other;

        if (latitude != obj.latitude || longitude != obj.longitude)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "latitude: " + latitude + ", longitude: " + longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}