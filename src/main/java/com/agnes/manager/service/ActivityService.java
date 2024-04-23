package com.agnes.manager.service;

import com.agnes.manager.dto.ActivityDTO;
import com.agnes.manager.model.Activity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityService {
    public List<ActivityDTO> convertToDTOList(List<Activity> activities) {
        List<ActivityDTO> dtos = new ArrayList<>();
        for (Activity activity : activities) {
            ActivityDTO dto = new ActivityDTO(
                    activity.getId(),
                    activity.getName(),
                    activity.getProject().getId(),
                    activity.getStartDate().toString(),
                    activity.getEndDate().toString()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
