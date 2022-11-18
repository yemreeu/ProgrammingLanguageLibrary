package com.example.ProgrammingLanguagesV2Application.dataAccess.abstracts;

import com.example.ProgrammingLanguagesV2Application.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Integer> {
}
