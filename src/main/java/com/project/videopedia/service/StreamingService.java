package com.project.videopedia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Set;
import java.util.HashSet;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import static java.nio.file.FileVisitResult.*;

@Service
public class StreamingService {

    private static final String FORMAT = "classpath:videos/%s";

    @Autowired
    private ResourceLoader resourceLoader;

    public Mono<Resource> getVideo(String title) {
	System.out.println(String.format(FORMAT, title));
        return Mono.fromSupplier(() -> this.resourceLoader.getResource( String.format(FORMAT, title)));
    }

    public Set<String> listFilesUsingFileWalkAndVisitor(String dir) throws IOException {
    	Set<String> fileList = new HashSet<>();
    	Files.walkFileTree(Paths.get(dir), new SimpleFileVisitor<Path>() {
        	@Override
        	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            		if (!Files.isDirectory(file)) {
                		fileList.add(file.getFileName().toString());
            		}
            		return FileVisitResult.CONTINUE;
        	}
    	});
    	return fileList;
	}
}
