package com.cherry.assignment.views;

import com.cherry.assignment.entities.Log;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class LogResponse implements Response{
    private String uid;

    private String message;

    private Date createdDate;

    private Date updatedDate;

    private String createdBy;

    private String updatedBy;

    public LogResponse(Log log) {
        this.uid = log.getUid();
        this.message = log.getMessage();
        this.createdDate = log.getCreatedDate();
        this.updatedDate = log.getUpdatedDate();
        this.createdBy = log.getCreatedBy();
        this.updatedBy = log.getUpdatedBy();
    }
}
