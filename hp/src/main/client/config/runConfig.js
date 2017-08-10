/**
 * Конфигурация на шаге Run в ангуларе
 */
export default function runConfig(templateRepository) {
    templateRepository.pages.index;
}

runConfig.$inject = [
    'templateRepository'
];