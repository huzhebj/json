package com.hualala.json.bean;
import lombok.Data;

import java.util.List;

@Data
public class AssessmentCategory {
    private String assessmentCategoryID;
    private String categoryName;
    private List<AssessmentTag> assessmentTagList;
}
