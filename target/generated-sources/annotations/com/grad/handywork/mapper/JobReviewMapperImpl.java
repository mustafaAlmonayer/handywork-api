package com.grad.handywork.mapper;

import com.grad.handywork.dto.JobReviewDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.JobReview;
import com.grad.handywork.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T08:55:18+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class JobReviewMapperImpl implements JobReviewMapper {

    @Override
    public JobReview jobReviewDtoTojobReview(JobReviewDto jobReviewDto) {
        if ( jobReviewDto == null ) {
            return null;
        }

        JobReview jobReview = new JobReview();

        jobReview.setType( jobReviewDto.getType() );
        jobReview.setRating( jobReviewDto.getRating() );
        jobReview.setPublishDate( jobReviewDto.getPublishDate() );
        jobReview.setReviewText( jobReviewDto.getReviewText() );

        return jobReview;
    }

    @Override
    public JobReviewDto jobReviewToJobReviewDto(JobReview jobReview) {
        if ( jobReview == null ) {
            return null;
        }

        JobReviewDto.JobReviewDtoBuilder jobReviewDto = JobReviewDto.builder();

        jobReviewDto.jobId( jobReviewJobId( jobReview ) );
        jobReviewDto.jobName( jobReviewJobJobName( jobReview ) );
        jobReviewDto.byUserUsername( jobReviewByUserUsername( jobReview ) );
        jobReviewDto.byUserUsernameImageUrl( jobReviewByUserPfpUrl( jobReview ) );
        jobReviewDto.onUserUsername( jobReviewOnUserUsername( jobReview ) );
        jobReviewDto.onUserUsernameImageUrl( jobReviewOnUserPfpUrl( jobReview ) );
        jobReviewDto.id( jobReview.getId() );
        jobReviewDto.type( jobReview.getType() );
        jobReviewDto.rating( jobReview.getRating() );
        jobReviewDto.publishDate( jobReview.getPublishDate() );
        jobReviewDto.updateDate( jobReview.getUpdateDate() );
        jobReviewDto.reviewText( jobReview.getReviewText() );

        return jobReviewDto.build();
    }

    private Long jobReviewJobId(JobReview jobReview) {
        if ( jobReview == null ) {
            return null;
        }
        Job job = jobReview.getJob();
        if ( job == null ) {
            return null;
        }
        Long id = job.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String jobReviewJobJobName(JobReview jobReview) {
        if ( jobReview == null ) {
            return null;
        }
        Job job = jobReview.getJob();
        if ( job == null ) {
            return null;
        }
        String jobName = job.getJobName();
        if ( jobName == null ) {
            return null;
        }
        return jobName;
    }

    private String jobReviewByUserUsername(JobReview jobReview) {
        if ( jobReview == null ) {
            return null;
        }
        User byUser = jobReview.getByUser();
        if ( byUser == null ) {
            return null;
        }
        String username = byUser.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String jobReviewByUserPfpUrl(JobReview jobReview) {
        if ( jobReview == null ) {
            return null;
        }
        User byUser = jobReview.getByUser();
        if ( byUser == null ) {
            return null;
        }
        String pfpUrl = byUser.getPfpUrl();
        if ( pfpUrl == null ) {
            return null;
        }
        return pfpUrl;
    }

    private String jobReviewOnUserUsername(JobReview jobReview) {
        if ( jobReview == null ) {
            return null;
        }
        User onUser = jobReview.getOnUser();
        if ( onUser == null ) {
            return null;
        }
        String username = onUser.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String jobReviewOnUserPfpUrl(JobReview jobReview) {
        if ( jobReview == null ) {
            return null;
        }
        User onUser = jobReview.getOnUser();
        if ( onUser == null ) {
            return null;
        }
        String pfpUrl = onUser.getPfpUrl();
        if ( pfpUrl == null ) {
            return null;
        }
        return pfpUrl;
    }
}
