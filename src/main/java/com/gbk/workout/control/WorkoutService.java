package com.gbk.workout.control;

import com.gbk.workout.boundary.WorkoutDto;
import com.gbk.workout.entity.Workout;
import com.gbk.workout.entity.WorkoutVariation;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class WorkoutService {

  public List<WorkoutDto> getWorkouts() {
    List<Workout> workouts = Workout.listAll();

    return workouts.stream()
        .map(
            workout -> {
              return WorkoutDto.from(
                  workout,
                  WorkoutVariation.find(
                          "select wv from WorkoutVariation wv where wv.workout.id = ?1", workout.id)
                      .list());
            })
        .toList();
  }

  public WorkoutDto getWorkout(long id) {
    Workout workout = Workout.findById(id);

    return WorkoutDto.from(
        workout,
        WorkoutVariation.find(
                "select wv from WorkoutVariation wv where wv.workout.id = ?1", workout.id)
            .list());
  }
}
