package com.gbk.workout.boundary;

import com.gbk.workout.entity.Workout;
import com.gbk.workout.entity.WorkoutVariation;
import java.util.List;

public record WorkoutDto(String name, List<String> workoutVariations) {
  public static WorkoutDto from(Workout workout, List<WorkoutVariation> workoutVariations) {
    return new WorkoutDto(
        workout.getName(),
        workoutVariations.stream()
            .map(workoutVariation -> workoutVariation.getVariationName())
            .toList());
  }
}
