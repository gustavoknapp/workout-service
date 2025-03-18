package com.gbk.workout.boundary;

import com.gbk.workout.control.WorkoutService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/workout")
@Produces(MediaType.APPLICATION_JSON)
public class WorkoutResource {

  private final WorkoutService workoutService;

  public WorkoutResource(final WorkoutService workoutService) {
    this.workoutService = workoutService;
  }

  @GET
  public Response getWorkouts() {
    return Response.ok(this.workoutService.getWorkouts()).build();
  }

  @GET
  @Path("/{id}")
  public Response getWorkout(@PathParam(value = "id") long id) {
    return Response.ok(this.workoutService.getWorkout(id)).build();
  }

}
