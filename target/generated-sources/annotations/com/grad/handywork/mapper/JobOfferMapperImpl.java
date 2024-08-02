package com.grad.handywork.mapper;

import com.grad.handywork.dto.JobOfferDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.JobOffer;
import com.grad.handywork.entity.User;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T09:35:49+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class JobOfferMapperImpl implements JobOfferMapper {

    @Override
    public JobOfferDto jobOfferToJobOfferDto(JobOffer jobOffer) {
        if ( jobOffer == null ) {
            return null;
        }

        JobOfferDto.JobOfferDtoBuilder jobOfferDto = JobOfferDto.builder();

        jobOfferDto.jobTitle( jobOfferJobJobName( jobOffer ) );
        jobOfferDto.jobId( jobOfferJobId( jobOffer ) );
        jobOfferDto.jobImageUrl( mapListOfStringToString( jobOfferJobImagesUrls( jobOffer ) ) );
        jobOfferDto.user( jobOfferUserUsername( jobOffer ) );
        jobOfferDto.userImageUrl( jobOfferUserPfpUrl( jobOffer ) );
        jobOfferDto.id( jobOffer.getId() );
        jobOfferDto.suggestedAmount( jobOffer.getSuggestedAmount() );
        jobOfferDto.accepted( jobOffer.getAccepted() );
        jobOfferDto.rejected( jobOffer.getRejected() );

        return jobOfferDto.build();
    }

    @Override
    public JobOffer jobOfferDtoToJobOffer(JobOfferDto jobOfferDto) {
        if ( jobOfferDto == null ) {
            return null;
        }

        JobOffer jobOffer = new JobOffer();

        jobOffer.setSuggestedAmount( jobOfferDto.getSuggestedAmount() );

        return jobOffer;
    }

    private String jobOfferJobJobName(JobOffer jobOffer) {
        if ( jobOffer == null ) {
            return null;
        }
        Job job = jobOffer.getJob();
        if ( job == null ) {
            return null;
        }
        String jobName = job.getJobName();
        if ( jobName == null ) {
            return null;
        }
        return jobName;
    }

    private Long jobOfferJobId(JobOffer jobOffer) {
        if ( jobOffer == null ) {
            return null;
        }
        Job job = jobOffer.getJob();
        if ( job == null ) {
            return null;
        }
        Long id = job.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private List<String> jobOfferJobImagesUrls(JobOffer jobOffer) {
        if ( jobOffer == null ) {
            return null;
        }
        Job job = jobOffer.getJob();
        if ( job == null ) {
            return null;
        }
        List<String> imagesUrls = job.getImagesUrls();
        if ( imagesUrls == null ) {
            return null;
        }
        return imagesUrls;
    }

    private String jobOfferUserUsername(JobOffer jobOffer) {
        if ( jobOffer == null ) {
            return null;
        }
        User user = jobOffer.getUser();
        if ( user == null ) {
            return null;
        }
        String username = user.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String jobOfferUserPfpUrl(JobOffer jobOffer) {
        if ( jobOffer == null ) {
            return null;
        }
        User user = jobOffer.getUser();
        if ( user == null ) {
            return null;
        }
        String pfpUrl = user.getPfpUrl();
        if ( pfpUrl == null ) {
            return null;
        }
        return pfpUrl;
    }
}
