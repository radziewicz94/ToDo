package pl.mradziewicz.ToDo.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mradziewicz.ToDo.model.Task;
import pl.mradziewicz.ToDo.model.TaskGroupRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TempServ {

    @Autowired
    List<String> temp(TaskGroupRepository taskGroupRepository){
        return taskGroupRepository.findAll().stream()
                .flatMap(taskGroup -> taskGroup.getTasks().stream())
                .map(Task::getDescription)
                .collect(Collectors.toList());
    }
}
