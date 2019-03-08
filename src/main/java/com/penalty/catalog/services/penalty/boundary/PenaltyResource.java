package com.penalty.catalog.services.penalty.boundary;

import com.penalty.catalog.services.penalty.entity.Category;
import com.penalty.catalog.services.penalty.entity.Penalty;
import com.penalty.catalog.services.penalty.entity.Team;

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

    @Inject
    CategoryService categoryService;

    @Inject
    TeamService teamService;

    @GET
    public String penalties () {
        return this.penaltyService.getPenalties().toString();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(JsonObject penalty) {

        String penaltyName = penalty.getString("penaltyName");
        String description = penalty.getString("description");
        Penalty.Weight weight = Penalty.Weight.valueOf(penalty.getString("weight"));
        double amount = Double.parseDouble(penalty.getString("amount"));
        int unit = Integer.parseInt(penalty.getString("unit"));
        String categoryName = penalty.getString("categoryName");
        String teamId = penalty.getString("teamId");

        Category category = categoryService.getCategoryIfItExists(categoryName);
        Team team = teamService.getTeam(teamId);

        if(category != null) {
            this.penaltyService.savePenalty(new Penalty(penaltyName, description, weight, amount, unit, category, new Team("ASV", "Neumarkt")));
        }
        else {
            this.penaltyService.savePenalty(new Penalty(penaltyName, description, weight, amount, unit, new Category(categoryName), new Team("ASV", "Neumarkt")));
        }
    }

}
