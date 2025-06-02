package com.example.bcsd.controller;

import com.example.bcsd.dto.request.MemberRequest;
import com.example.bcsd.dto.resopnse.MemberResponse;
import com.example.bcsd.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberResponse> getMemberById(@PathVariable Long id) {
        return ResponseEntity
                .ok(memberService.getMemberById(id));
    }

    @PostMapping()
    public ResponseEntity<MemberResponse> createMember(@RequestBody @Valid MemberRequest request) {
        MemberResponse response = memberService.createMember(request);

        return ResponseEntity.created(URI.create("/members/" + response.id()))
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @RequestBody @Valid MemberRequest request) {
        return ResponseEntity
                .ok(memberService.updateMember(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);

        return ResponseEntity.noContent().build();
    }
}
