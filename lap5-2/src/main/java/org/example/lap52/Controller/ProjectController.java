package org.example.lap52.Controller;

import org.example.lap52.Api.ApiResponse;
import org.example.lap52.Model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    ArrayList<Project> projects =new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Project> getTasks() {
        return projects;
    }

    @PostMapping("/add")
    public ApiResponse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResponse ("project added successfully") ;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateProject(@PathVariable int index, @RequestBody Project project) {
        projects.set(index, project);
        return new ApiResponse("project updated successfully") ;
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResponse("Project deleted successfully") ;

    }
    @PutMapping("/change/{index}")
    public ApiResponse changeProject(@PathVariable int index) {
        projects.get(index).status = !projects.get(index).status;
        return new ApiResponse("Status changed to " + projects.get(index).getStatus() + "!") ;

    }
    @GetMapping("/search")
    public List<Project> searchProject(@RequestBody String title) {
        List<Project> search = new ArrayList<>();
        for (Project project : projects) {
            if (project.getTitle().equalsIgnoreCase(title)) {
                search.add(project);
            }
        }
        return search;

    }

    @GetMapping("/display")
        public List<Project> displayingByCompany(@RequestBody String companyName) {
        List<Project> result = new ArrayList<>();
        for (Project project : projects) {
            if (project.companyName.equals(companyName)) {
                result.add(project);
            }
        }
        return result;
    }
}

