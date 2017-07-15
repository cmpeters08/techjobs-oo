package org.launchcode.controllers;

import org.launchcode.models.Employer;
import org.launchcode.models.Job;
import org.launchcode.models.forms.JobForm;
import org.launchcode.models.data.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "job")
public class JobController {

    private JobData jobData = JobData.getInstance();

    // The detail display for a given Job at URLs like /job?id=17
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index(Model model, int id) {

        // TODO #1 - get the Job with the given ID and pass it into the view
       Job newJob = jobData.findById(id);
       model.addAttribute("newJob", newJob);

       //successfully sends id to the query string.

        model.addAttribute("name", newJob.getName());
        model.addAttribute("employer", newJob.getEmployer());
        model.addAttribute("location", newJob.getLocation());
        model.addAttribute("position", newJob.getPositionType());
        model.addAttribute("skill", newJob.getCoreCompetency());


        return "job-detail";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute(new JobForm());
        return "new-job";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @Valid JobForm jobForm, Errors errors) {

        // TODO #6 - Validate the JobForm model, and if valid, create a
        // new Job and add it to the jobData data store. Then
        // redirect to the job detail view for the new Job.

        //if we know it's valid get employer id from jobform
        Employer theEmployer =  jobData.getEmployers().findById(jobForm.getEmployerId());

       // Job newJob = new Job(name, theEmployer, ...); what other things may look like.


        return "";

    }
}
