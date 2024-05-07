package com.project.videopedia;

import com.project.videopedia.service.StreamingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.io.*;

@RestController
public class StreamingController {

    @Autowired
    private StreamingService service;
    
    @Value("${spring.application.name}")
    private String name;
    
    @Value("${spring.application.media.music}")
    private String music_dir;

    @GetMapping(value = "video/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        System.out.println(range);
        System.out.println("=========== " + name + " ===========");
        return service.getVideo(title);
    }
    
    @GetMapping(value = "video", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> getMedia() {
	try {
    		return service.listFilesUsingFileWalkAndVisitor(music_dir);
	}
	catch(IOException e) {
		e.printStackTrace();
	}
	return null;
    }

}
