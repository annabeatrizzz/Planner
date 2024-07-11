package com.rocketseat.planner.participant;

import com.rocketseat.planner.trip.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParticipantService {

    //ATTRIBUTES
    @Autowired
    private ParticipantRepository repository;

    //METHOD
    public void registerParticipantsToEvent(List<String> participantsToInvite, Trip trip) {
        List<Participant> participants = participantsToInvite.stream().map(email -> new Participant(email, trip)).toList();


        //salvar em massa os participantes
        this.repository.saveAll(participants);
        System.out.println(participants.get(0).getId());
    };

    public ParticipantCreateResponse registerParticipantToEvent(String email, Trip trip){
        Participant newParticipant = new Participant(email, trip);
        this.repository.save(newParticipant);

        return new ParticipantCreateResponse(newParticipant.getId());
    }

    //function to send the email to all participants
    public void triggerConfirmationEmailToParticipants(UUID tripId){};

    //function to send the email to 1 participant
    public void triggerConfirmationEmailToParticipant(String email){};

    public List<ParticipantData> getAllParticipantsFromEvent(UUID tripid){
        return this.repository.findByTripId(tripid).stream().map(participant -> new ParticipantData(participant.getId(), participant.getName(), participant.getEmail(), participant.getIsConfirmed())).toList();
    }
}