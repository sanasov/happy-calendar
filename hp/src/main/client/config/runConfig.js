/**
 * Конфигурация на шаге Run в ангуларе
 */
export default function runConfig(templateRepository) {
    templateRepository.pages.index;
    templateRepository.pages.login;
}

runConfig.$inject = [
    'templateRepository'
];