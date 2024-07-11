package com.rocketseat.planner.link;

import com.rocketseat.planner.trip.Trip;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "links")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    //entidade que irá representar um Link

    //ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    //METHODS
    public Link(String title, String url, Trip trip){
        this.title = title;
        this.url = url;
        this.trip = trip;
    }
}