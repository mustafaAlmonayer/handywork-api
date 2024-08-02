package com.grad.handywork.mapper;

import com.grad.handywork.dto.JobDto;
import com.grad.handywork.entity.Job;
import com.grad.handywork.entity.User;
import com.grad.handywork.enumtypes.Cities;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-02T09:35:48+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 21.0.4 (Amazon.com Inc.)"
)
@Component
public class JobMapperImpl implements JobMapper {

    @Override
    public Job JobDtoToJobForSave(JobDto jobDto) {
        if ( jobDto == null ) {
            return null;
        }

        Job job = new Job();

        job.setField( jobDto.getField() );
        job.setDescription( jobDto.getDescription() );
        job.setPublishDate( jobDto.getPublishDate() );
        job.setJobName( jobDto.getJobName() );
        List<String> list = jobDto.getImagesUrls();
        if ( list != null ) {
            job.setImagesUrls( new ArrayList<String>( list ) );
        }
        if ( jobDto.getCity() != null ) {
            job.setCity( Enum.valueOf( Cities.class, jobDto.getCity() ) );
        }
        if ( jobDto.getDone() != null ) {
            job.setDone( jobDto.getDone() );
        }

        return job;
    }

    @Override
    public JobDto jobToJobDto(Job job) {
        if ( job == null ) {
            return null;
        }

        JobDto.JobDtoBuilder jobDto = JobDto.builder();

        jobDto.owner( jobOwnerUsername( job ) );
        String username1 = jobDoneByUsername( job );
        if ( username1 != null ) {
            jobDto.doneBy( username1 );
        }
        else {
            jobDto.doneBy( "" );
        }
        jobDto.id( job.getId() );
        jobDto.field( job.getField() );
        jobDto.description( job.getDescription() );
        jobDto.publishDate( job.getPublishDate() );
        jobDto.updateDate( job.getUpdateDate() );
        jobDto.jobName( job.getJobName() );
        List<String> list = job.getImagesUrls();
        if ( list != null ) {
            jobDto.imagesUrls( new ArrayList<String>( list ) );
        }
        jobDto.done( job.isDone() );
        if ( job.getCity() != null ) {
            jobDto.city( job.getCity().name() );
        }
        List<String> list1 = job.getImagesFiles();
        if ( list1 != null ) {
            jobDto.imagesFiles( new ArrayList<String>( list1 ) );
        }

        return jobDto.build();
    }

    @Override
    public JobDto jobToJobDtoForBrowse(Job job) {
        if ( job == null ) {
            return null;
        }

        JobDto.JobDtoBuilder jobDto = JobDto.builder();

        jobDto.owner( jobOwnerUsername( job ) );
        jobDto.id( job.getId() );
        jobDto.field( job.getField() );
        jobDto.description( job.getDescription() );
        jobDto.publishDate( job.getPublishDate() );
        jobDto.updateDate( job.getUpdateDate() );
        jobDto.jobName( job.getJobName() );
        List<String> list = job.getImagesUrls();
        if ( list != null ) {
            jobDto.imagesUrls( new ArrayList<String>( list ) );
        }
        if ( job.getCity() != null ) {
            jobDto.city( job.getCity().name() );
        }
        List<String> list1 = job.getImagesFiles();
        if ( list1 != null ) {
            jobDto.imagesFiles( new ArrayList<String>( list1 ) );
        }

        return jobDto.build();
    }

    private String jobOwnerUsername(Job job) {
        if ( job == null ) {
            return null;
        }
        User owner = job.getOwner();
        if ( owner == null ) {
            return null;
        }
        String username = owner.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }

    private String jobDoneByUsername(Job job) {
        if ( job == null ) {
            return null;
        }
        User doneBy = job.getDoneBy();
        if ( doneBy == null ) {
            return null;
        }
        String username = doneBy.getUsername();
        if ( username == null ) {
            return null;
        }
        return username;
    }
}
