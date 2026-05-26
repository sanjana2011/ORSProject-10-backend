package com.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.rays.common.BaseDTO;

@Entity
@Table(name = "st_podcast")
public class PodcastDTO extends BaseDTO {

    @Column(name = "podcast_code", length = 50)
    private String podcastCode;

    @Column(name = "podcast_title", length = 50)
    private String podcastTitle;

    @Column(name = "host_name", length = 50)
    private String hostName;

    @Column(name = "status", length = 20)
    private String status;

    public String getPodcastCode() {
        return podcastCode;
    }

    public void setPodcastCode(String podcastCode) {
        this.podcastCode = podcastCode;
    }

    public String getPodcastTitle() {
        return podcastTitle;
    }

    public void setPodcastTitle(String podcastTitle) {
        this.podcastTitle = podcastTitle;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getUniqueKey() {
        return "podcastCode";
    }

    @Override
    public String getUniqueValue() {
        return podcastCode;
    }

    @Override
    public String getLabel() {
        return "Podcast Code";
    }

    @Override
    public String getTableName() {
        return "Podcast";
    }

    @Override
    public String getValue() {
        return null;
    }
}