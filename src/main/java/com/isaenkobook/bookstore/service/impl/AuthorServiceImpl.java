package com.isaenkobook.bookstore.service.impl;

import com.isaenkobook.bookstore.mapper.AuthorMapper;
import com.isaenkobook.bookstore.model.Author;
import com.isaenkobook.bookstore.model.dto.AuthorReqDTO;
import com.isaenkobook.bookstore.model.dto.AuthorRespDTO;
import com.isaenkobook.bookstore.repository.AuthorRepository;
import com.isaenkobook.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorRespDTO> findAuthors() {
        return authorRepository.findAll().stream().map(authorMapper::toAuthorRespDTO).toList();
    }

    @Override
    public Optional<AuthorRespDTO> findAuthorById(Long authorId) {
        return authorRepository.findById(authorId).map(authorMapper::toAuthorRespDTO);
    }

    @Override
    public AuthorRespDTO createAuthor(AuthorReqDTO authorReqDTO) {
        Author author = authorMapper.toAuthor(authorReqDTO);
        Author saveAuthorInBase = authorRepository.save(author);
        return authorMapper.toAuthorRespDTO(saveAuthorInBase);
    }

    @Override
    public AuthorRespDTO updateAuthor(Map<Object, Object> fields, Long authorId) {
        if (authorRepository.existsById(authorId)) {
            Optional<Author> authorInBase = authorRepository.findById(authorId);
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(Author.class, (String) key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, authorInBase.get(), value);
            });
            Author updateAuthor = authorRepository.save(authorInBase.get());
            return authorMapper.toAuthorRespDTO(updateAuthor);
        }
        return null;
    }

    @Override
    public boolean deleteAuthor(Long authorId) {
        if (authorRepository.existsById(authorId)) {
            authorRepository.deleteById(authorId);
            return true;
        }
        return false;
    }
}
