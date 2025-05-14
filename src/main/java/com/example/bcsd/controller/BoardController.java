package com.example.bcsd.controller;

import com.example.bcsd.dto.request.BoardRequest;
import com.example.bcsd.dto.resopnse.BoardResponse;
import com.example.bcsd.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping
    public ResponseEntity<List<BoardResponse>> getAllBoards() {
        return ResponseEntity
                .ok(boardService.getAllBoards());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoardById(@PathVariable Long id) {
        return ResponseEntity
                .ok(boardService.getBoardById(id));
    }

    @PostMapping
    public ResponseEntity<BoardResponse> createBoard(@RequestBody BoardRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(boardService.createBoard(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponse> updateArticleById(
            @PathVariable Long id, @RequestBody BoardRequest request
    ) {
        return ResponseEntity
                .ok(boardService.updateBoardById(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoardById(@PathVariable Long id) {
        boardService.deleteBoardById(id);

        return ResponseEntity.noContent().build();
    }
}
