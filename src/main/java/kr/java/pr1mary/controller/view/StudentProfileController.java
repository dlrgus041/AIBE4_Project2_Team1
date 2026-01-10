package kr.java.pr1mary.controller.view;

import kr.java.pr1mary.dto.view.StudentDTO;
import kr.java.pr1mary.service.StudentProfileService;
import kr.java.pr1mary.service.TeacherProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile/student")
@RequiredArgsConstructor
public class StudentProfileController {
    private final StudentProfileService profileService;

    // 프로필 페이지
    @GetMapping
    public String studentProfilePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("profile", profileService.getProfileByStudentId(id));
        return "pages/profiles/student-profile";
    }

    // 프로필 편집 페이지
    @GetMapping("/update")
    public String updateStudentProfilePage(@RequestParam("id") Long id, Model model) {
        model.addAttribute("profile", profileService.getProfileByStudentId(id));
        return "pages/profiles/student-profile-update";
    }

    // 프로필 이미지 수정
    @PostMapping("/update/image")
    public String updateStudentProfileImage(@RequestBody StudentDTO dto) {
        profileService.setStudentImage(dto);
        return "redirect:/profile/student/update";
    }

    // 프로필 한줄 소개 수정
    @PostMapping("/update/introduce")
    public String updateStudentProfileIntroduce(@RequestBody StudentDTO dto) {
        profileService.setStudentIntroduce(dto);
        return "redirect:/profile/student/update";
    }
}
