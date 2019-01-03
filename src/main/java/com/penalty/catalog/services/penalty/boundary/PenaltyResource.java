package com.penalty.catalog.services.penalty.boundary;

import com.penalty.catalog.services.penalty.entity.Category;
import com.penalty.catalog.services.penalty.entity.Penalty;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("penalty")
public class PenaltyResource {

    @Inject
    PenaltyService penaltyService;

    @GET
    public String penalties () {
        return this.penaltyService.getPenalties().toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(JsonObject penalty) {
        String name = penalty.getString("name");
        Penalty myPenalty = new Penalty(name, "Fake", Penalty.Weight.HIGH, 0.0, 0, new Category("Trinken"));
        this.penaltyService.savePenalty(myPenalty);
    }

}
