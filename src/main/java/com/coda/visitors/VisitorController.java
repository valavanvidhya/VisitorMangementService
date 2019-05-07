package com.coda.visitors;


import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;
import java.util.List;

@RestController



public class VisitorController {

    VisitorRepo repo = new VisitorRepo();

    @RequestMapping("/")
    public String helloWorld() {

        return "helloWorld";
    }


    @PostMapping("/createvisitor")
    public VisitorModel createVisitor(@RequestBody VisitorModel visitor) throws SQLException {

        repo.createVisitor(visitor);
        return visitor;

    }

    @PutMapping("/exitvisitor")
    public VisitorModel2 exitVisitor(@RequestBody VisitorModel2 visitor) throws SQLException {

        repo.updateOutTime(visitor);
        return visitor;

    }

    @PutMapping("/editvisitor")
    public VisitorModel2 editVisitor(@RequestBody VisitorModel2 visitor) throws SQLException {

        repo.editVisitor(visitor);
        return visitor;

    }


    @DeleteMapping  ("/deletevisitor/{VisitorId}")
    public String deletevisitor( Integer VisitorId) throws SQLException {
        VisitorModel2 visitor = repo.getsinglevisitor(VisitorId);

        if(visitor.getVisitorId()!= 0) {
            repo.deleteVisitor(VisitorId);
        }
        return "Deleted";

    }

    @GetMapping  ("/listallvisitors")
    public List<VisitorModel2> listallvisitors() throws SQLException {

        return repo.getvisitor();


    }

    @GetMapping("/getvisitor/{VisitorId}")
    public VisitorModel2 getSingleVisitor(int VisitorId) throws SQLException {


        return repo.getsinglevisitor(VisitorId);

    }



}
