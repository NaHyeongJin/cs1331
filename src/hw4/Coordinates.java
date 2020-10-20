package hw4;

/**
 * Coordinates
 */
public class Coordinates {
    final double latitude; // 좌표 집합의 위도
    final double longitude; // 좌표 집합의 경도

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // 위도 경도 같아야 true
    @Override
    public boolean equals(Object other) {
        Coordinates obj;
        if (other instanceof Coordinates) {
            obj = (Coordinates) other;
        } else {
            return false;
        }
        return (obj.latitude == this.latitude && obj.longitude == this.longitude);
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