package com.example.bcsd.controller;

import com.example.bcsd.dto.request.BoardRequest;
import com.example.bcsd.dto.resopnse.BoardResponse;
import com.example.bcsd.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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
    public ResponseEntity<BoardResponse> createBoard(@RequestBody @Valid BoardRequest request) {
        BoardResponse response = boardService.createBoard(request);

        return ResponseEntity
                .created(URI.create("/boards/" + response.id()))
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BoardResponse> updateArticleById(
            @PathVariable Long id, @RequestBody @Valid BoardRequest request
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
