---
title: "Code - Flights"
---


{{%expand "Flight" %}}

```java
package src;

public interface Flight {
    public int getDistance();
    default public double getFinalPrice(FlightClass flightClass) {
        return getDistance() * flightClass.getPriceFactor();
    }
}
```

{{% /expand%}}
{{%expand "Airport" %}}

```java
package src;

import java.util.Objects;

public class Airport {
    private final String name;

    public Airport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
```

{{% /expand%}}
{{%expand "FlightClass" %}}

```java
package src;

public enum FlightClass {
    ECONOMY(0.1), BUSINESS(0.2), FIRST(0.3);

    private final double priceFactor;

    FlightClass(double priceFactor) {
        this.priceFactor = priceFactor;
    }

    public double getPriceFactor() {
        return priceFactor;
    }
}
```

{{% /expand%}}
{{%expand "OneWayFlight" %}}

```java
package src;

import java.util.Arrays;
import java.util.List;

public abstract class OneWayFlight implements Flight {
    protected final int distance;
    protected final Airport startAirport;
    protected final Airport endAirport;

    public OneWayFlight(int distance, Airport startAirport, Airport endAirport) {
        if (startAirport.equals(endAirport)) {
            throw new IllegalArgumentException("Start and end airport must be different");
        }
        this.distance = distance;
        this.startAirport = startAirport;
        this.endAirport = endAirport;
    }

    @Override
    public int getDistance() {
        return distance;
    }

    public Airport getStartAirport() {
        return startAirport;
    }

    public Airport getEndAirport() {
        return endAirport;
    }
}

class NonStopFlight extends OneWayFlight {
    public NonStopFlight(int distance, Airport startAirport, Airport endAirport) {
        super(distance, startAirport, endAirport);
    }
}

class StopOverFlight extends OneWayFlight {
    private final List<Airport> airports;

    public StopOverFlight(int distance, Airport startAirport, Airport endAirport, Airport... airports) {
        super(distance, startAirport, endAirport);
        this.airports = Arrays.asList(airports);
    }

    public List<Airport> getAirports() {
        return airports;
    }
}
```

{{% /expand%}}
{{%expand "OpenFlight" %}}

```java
package src;

import java.util.Arrays;
import java.util.List;

public class OpenFlight implements Flight {
    private final List<OneWayFlight> flights;

    public OpenFlight(OneWayFlight... flights) {
        this.flights = Arrays.asList(flights);
    }

    @Override
    public int getDistance() {
        return flights.stream().mapToInt(OneWayFlight::getDistance).sum();
    }

    public Airport getStartAirport() {
        return flights.get(0).getStartAirport();
    }

    public Airport getEndAirport() {
        return flights.get(flights.size() - 1).getEndAirport();
    }

    public List<OneWayFlight> getFlights() {
        return flights;
    }
}

class RoundTripFlight extends OpenFlight {
    public RoundTripFlight(OneWayFlight outbound, OneWayFlight returnFlight) {
        super(outbound, returnFlight);
    }
}

```

{{% /expand%}}
{{%expand "Main" %}}

```java
package src;

public class Main {
    public static void main(String[] args) {

        new StopOverFlight(2050, new Airport("München"), new Airport("Paris"),
        new Airport("New York"), new Airport("Seattle"));
        Airport munich = new Airport("Munich");
        Airport paris = new Airport("Paris");
        NonStopFlight nonStopFlight = new NonStopFlight(670, munich, paris);

        assert nonStopFlight.getDistance() == 670;
        assert nonStopFlight.getStartAirport().equals(munich);
        assert nonStopFlight.getEndAirport().equals(paris);

    }
}
```

{{% /expand%}}