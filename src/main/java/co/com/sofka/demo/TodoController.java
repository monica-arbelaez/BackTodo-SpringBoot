package co.com.sofka.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping(value = "api/todos")
    public Iterable<Todo> list(){
        return service.list();
    }

    @PostMapping("api/todo")
    public Todo save(@RequestBody Todo todo){
        return service.save(todo);
    }

    @PutMapping("api/todo")
    public Todo update(@RequestBody Todo todo){
        if (todo.getId() != null)
            return service.save(todo);
        throw new RuntimeException("No exite el id para actualizar");
    }

    @DeleteMapping("api/{id}/todo")
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }
    @GetMapping(value = "api/{id}/todo")
    public Todo get(@PathVariable("id") Long id){
        return service.get(id);
    }
}
