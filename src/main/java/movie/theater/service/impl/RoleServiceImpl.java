package movie.theater.service.impl;

import lombok.RequiredArgsConstructor;
import movie.theater.model.Role;
import movie.theater.repository.RoleRepository;
import movie.theater.service.RoleService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Override
    public void add(Role role) {
        roleRepository.save(role);
//        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleRepository.getRoleByName(roleName);
//        return roleDao.getRoleByName(roleName).orElseThrow(() ->
//                new DataProcessingException("Can't find role for name " + roleName));
    }
}
