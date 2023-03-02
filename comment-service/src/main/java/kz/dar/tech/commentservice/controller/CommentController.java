package kz.dar.tech.commentservice.controller;

import kz.dar.tech.commentservice.document.Comment;
import kz.dar.tech.commentservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @GetMapping("/{id}")
    public Comment getCommentById(
            @PathVariable String id
    ) {
        return commentService.getCommentById(
                id
        );
    }

    @PostMapping
    public boolean createComment(
            @RequestBody Comment comment
    ) {
        return commentService.createComment(
                comment
        );
    }

    @DeleteMapping("/{id}")
    public void deleteComment(
            @PathVariable String id
    ) {
        commentService.deleteComment(
                id
        );
    }

}